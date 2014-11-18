package com.lis.service.impl;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lis.dao.AlgorithmWeightDao;
import com.lis.dao.BussinessKeywordDao;
import com.lis.dao.Method1Dao;
import com.lis.dao.Method2Dao;
import com.lis.dao.NetworkRelationDao;
import com.lis.dao.QuerySettingDao;
import com.lis.dao.IntermediateWordDao;
import com.lis.dao.TFIDFDao;
import com.lis.model.AlgorithmWeight;
import com.lis.model.BussinessKeyword;
import com.lis.model.IntermediateWord;
import com.lis.model.Method1;
import com.lis.model.Method2;
import com.lis.model.NetworkRelation;
import com.lis.model.QuerySetting;
import com.lis.model.TFIDF;
import com.lis.service.ClusterService;

@Service("clusterService")
@Transactional
public class ClusterServiceImpl implements ClusterService{
	@Autowired
	private BussinessKeywordDao bussinessKeywordDao;
	private AlgorithmWeightDao algorithmWeightDao;
	private TFIDFDao tfidfDao;
	private QuerySettingDao querySettingDao;
	private NetworkRelationDao networkRelationDao;
	private Method1Dao method1Dao;
	private Method2Dao method2Dao;
	private IntermediateWordDao IntermediateWordDao;
	
	@Autowired
	public void setBussinessKeywordDao(BussinessKeywordDao bussinessKeywordDao) {
		this.bussinessKeywordDao = bussinessKeywordDao;
	}
	@Autowired
	public void setTfidfDao(TFIDFDao tfidfDao) {
		this.tfidfDao = tfidfDao;
	}
	@Autowired
	public void setAlgorithmWeightDao(AlgorithmWeightDao algorithmWeightDao) {
		this.algorithmWeightDao = algorithmWeightDao;
	}
	@Autowired
	public void setQuerySettingDao(QuerySettingDao querySettingDao) {
		this.querySettingDao = querySettingDao;
	}
	@Autowired
	public void setNetworkRelationDao(NetworkRelationDao networkRelationDao) {
		this.networkRelationDao = networkRelationDao;
	}
	
	@Autowired
	public void setMethod1Dao(Method1Dao method1Dao) {
		this.method1Dao = method1Dao;
	}

	@Autowired
	public void setMethod2Dao(Method2Dao method2Dao) {
		this.method2Dao = method2Dao;
	}

	@Autowired
	public void setIntermediateWordDao(IntermediateWordDao intermediateWordDao) {
		IntermediateWordDao = intermediateWordDao;
	}



	private List<String> s1,s2;
	private double[] index0,index1;//用来标记分数
	private int showNum = 0;
	private double[] poit;// = new double[10];//用以记录要输出的词汇的分数
	private String[] x;// = new String[10];//用来输出十个词汇
	private ArrayList xLit = new ArrayList<String>();//内部存储这要输出的十个词汇，便于运算
	private ArrayList recordAssociateWord = new ArrayList<String>();//在其他主题词中匹配到的词汇
	private ArrayList recordAssociatePoit = new ArrayList();//匹配到的词汇的分数
	int recordAssociateNum = 0;//总共匹配到的个数
    //方法一获取排好序的名词
	public List<String> method1(List<String> noun){

		List outList = new ArrayList<String>();
		String result;
		Hashtable hash=new Hashtable();
        //从名词excel文件中提取数据并计算词频
        for(int i = 0;i<noun.size();i++) {
                //Cell cell = cellIterator.next();
                result = noun.get(i);
            	if(hash.containsKey(result)){
            		int f = Integer.parseInt(hash.get(result).toString());
            		f++;
            		hash.put(result, f);   		
            	}else{
            		hash.put(result, 1);	
            	}
            	}//end while 
        //提取tf-idf文件中的数值
        Hashtable hash_2 = new Hashtable();
        String s;
        double d;
        List<TFIDF> tfIdf = tfidfDao.list();
  
		
		for(int i = 0;i<tfIdf.size();i++){
			s = tfIdf.get(i).getWord().trim();
			d = tfIdf.get(i).getScore();
			
			hash_2.put(s, d);
		}
        
        //遍历哈希表
        Set ss=hash.keySet();
        String key = new String();
       //计算tf-idf值
        for(Iterator<String> i=ss.iterator();i.hasNext();){
        	key = i.next().trim();
        	
        	if(hash_2.containsKey(key)){
        		int tf = Integer.parseInt(hash.get(key).toString());
        		double idf = Double.parseDouble(hash_2.get(key).toString());
        		hash.put(key, tf*idf);
        	}else{
        		hash.put(key,0.1);      		
        	}      
        }
        
        key = null;      
        //对所有字符串按照tf-idf排序并输出
        Set ss2=hash.keySet();
        
        String tmp = "";
   
        int size = hash.size();
        for(int j = 0;j<size;j++){
        	ss2=hash.keySet();
        	double max = 0;
        	for(Iterator<String> i=ss2.iterator();i.hasNext();){
        		key = i.next().trim();
        		double xxoo = Double.parseDouble(hash.get(key).toString());
        		if(xxoo>max){
        		//一遍循环找最大值
        			max = xxoo;
        			tmp = key; 			
        		}   
        	}
        
        	hash.remove(tmp);
           	
        	ss=hash.keySet();
        	
    	    if(!outList.contains(tmp))
        	  outList.add(tmp);     	
        }
        

        //将outList中的数据存为method1对象，并且存入数据库
        Method1 method1 = null;
        for(int i = 0; i < outList.size(); i++){
        	method1 = new Method1();
        	method1.setName((String) outList.get(i));
        	method1Dao.save(method1);
        }
        return outList;
	}
	//方法二获取匹配的关键词
	public List<String> method2(List<String> noun){
		//StringBuffer keyword1 = new StringBuffer();
		List<String> x = new ArrayList<String>();
        try
        {
        	List<BussinessKeyword> keyWordList = bussinessKeywordDao.list();
       
         int srcLength=noun.size();
         int keywordLength=keyWordList.size();
        
         //初始化匹配记录数组（0为未与关键词匹配成功）
         int[] mapResult = new int[keywordLength];
         for(int s=0; s<keywordLength; s++) {
         	mapResult[s]=0;
         }
         
          int i=0;//关键词数组计数器
          
          //匹配函数写匹配记录数组（1为与关键词匹配成功）
         while(i<=srcLength-1) {

       			for(int j=0; j<keywordLength; j++) {
       				if(noun.get(i).trim().equals(keyWordList.get(j).getBussinessKeyword().trim())) 
       				{
       					mapResult[j]=1;
       			}
       		}
       			i++;
        }      
         //根据匹配记录，倒序输出匹配结果
        for(int t=keywordLength-1; t>=0; t--) {
        	if(mapResult[t] == 1) {   		 
                //keyword1.append(keyWord[t]+" ");
        		x.add(keyWordList.get(t).getBussinessKeyword());
        	}
        }  
      
      //将outList中的数据存为method2对象，并且存入数据库
        Method2 method2 = null;
        for(int j = 0; j < x.size(); j++){
        	method2 = new Method2();
        	method2.setName((String) x.get(j));
        	method2Dao.save(method2);
        }
    }catch (Exception e) {
        System.out.println(e);
    }
        
        return x;
}
    //综合方法一方法二的数据返回特定数据量的关键词
	public List<String> megaOutPut(List<String> noun) throws Exception{
		
		s1 = method1(noun);
		s2 = method2(noun);
		
		int num = s1.size()+s2.size();
		
		xLit.clear();
		recordAssociateWord.clear();
		recordAssociatePoit.clear();
		recordAssociateNum = 0;
		initAndAllocate();
		//总数必须大于showNum
		if(num>=showNum){			
			sort();
			if(findAssociate())	
				reSort();
			
			//获取每个名词的分数
			double[] points = outPoint();
			
			//将名词和分数存入数据库
			int length = xLit.size();
			IntermediateWord intermediateWord = null;
			for(int i = 0; i < length;i++){
				intermediateWord = new IntermediateWord();
				intermediateWord.setWord((String) xLit.get(i));
				intermediateWord.setScore(points[i]);
				IntermediateWordDao.save(intermediateWord);
			}
			
			return xLit;
		}else{		
			xLit = null;
			return xLit;
		}
		
	}
	//对外输出对应分数,必须放在init函数之后，不能单独使用！
	public double[] outPoint(){
		return poit;
	}
	//对综合算法进行一些必要的初始化，从数据库中读取要输出的词个数以及各算法权重
	private void initAndAllocate(){
		//从数据库中找出要输出几个词汇
		List<QuerySetting> qsting = querySettingDao.list();
		showNum = qsting.get(0).getKeywordShowNumber();

		
		List<AlgorithmWeight> alwt = algorithmWeightDao.list();
		double i1 = alwt.get(0).getWeight();
		double i2 = alwt.get(1).getWeight();
		int s1s2Count = s1.size()+s2.size();
		if(showNum>0){
			index0 = new double[s1.size()];
			index1 = new double[s2.size()];
			poit = new double[showNum];
		}
		//为每个词赋予权重
		
			for(int j = 0;j<s1.size();j++){			
				index0[j] = (s1s2Count-j)*i1;
				//System.out.print(index0[j]);
			}
			for(int j = 0;j<s2.size();j++)
				index1[j] = (s1s2Count-j)*i2;
	
	}
	//进行排序
	//从处理好的词汇中选择前showNum个主题词
	private List<String> sort(){
		int i1 = 0, i2 = 0;
		//这里默认要展示的词数少于两字符串数量之和
		xLit.clear();
		for(int i = 0;i<showNum;){
			if(i1<s1.size()&&i2<s2.size()){
			if(index0[i1]>index1[i2]){
				
				if(!xLit.contains(s1.get(i1))){
					xLit.add(s1.get(i1));
					poit[i] = index0[i1];//将分数也记录下来
					//i1++;
					i++;
				}
				i1++;
				
			}else{
				if(!xLit.contains(s2.get(i2))){
					xLit.add(s2.get(i2));
					poit[i] = index1[i2];
					//i2++;
					i++;
				}
				i2++;
				}
			}else if(i1>=s1.size()){//s1已完
				if(!xLit.contains(s2.get(i2))){
				xLit.add(s2.get(i2));
				poit[i] = index1[i2];
				//i2++;
				i++;
				}
				i2++;
			}else if(i2>=s2.size()){//s2已完
				if(!xLit.contains(s1.get(i1))){
				xLit.add(s1.get(i1));
				poit[i] = index0[i1];
				//i1++;
				i++;
				}
				i1++;
			}
		}	 
		return xLit;
	}
	//在网络关系表中查找
	private boolean findAssociate() throws Exception{
		
		List<NetworkRelation> netRela = networkRelationDao.list();
		int rowNum = netRela.size();
		  
		  for(int i=0;i<rowNum;i++){
			  String[] ascia = netRela.get(i).getChildKeyword().toString().split(" ");
			  int count = 0;//用来计数一行有多少匹配
			  for(int j=0;j<ascia.length;j++){
				
				 if(xLit.contains(ascia[j])){
					 count++;				
				 }else
					 break;//有一个单元格不匹配，直接退出，避免浪费计算资源
				 
				 if(count == (ascia.length)){//如果这一条匹配，存入数组中
					 recordAssociateWord.add(netRela.get(i).getParentKeyword().trim());
					 recordAssociatePoit.add(netRela.get(i).getScore());
					
					 recordAssociateNum++;
				 }
			  }//end for			 
		  }//end for
		  if(recordAssociateNum>0)
			  return true;
		  else
			  return false;
		  
	}

	private void reSort(){
		double[] recordeAssociatePoitArray = new double[recordAssociateNum];
		for(int i = 0;i<recordAssociateNum;i++){//将关联词的分数转化为数组
			recordeAssociatePoitArray[i] = Double.parseDouble(recordAssociatePoit.get(i).toString());
			//System.out.print(recordeAssociatePoitArray[i]+" ");
		}
		ArrayList tmp = new ArrayList<String>(showNum);
		double[] tmpPoint = new double[showNum];
		int i1 = 0, i2 = 0;
		//将原数组与关联数组进行排序并选择前十个
		for(int i = 0;i<showNum;){
			if(i1<recordAssociateNum&&i2<showNum){
			if(recordeAssociatePoitArray[i1]>poit[i2]){
				
				if(!tmp.contains(recordAssociateWord.get(i1))){
					tmp.add(recordAssociateWord.get(i1));
					tmpPoint[i] = recordeAssociatePoitArray[i1];//将分数也记录下来
					//i1++;
					i++;
				}
				i1++;
				
			}else{
				if(!tmp.contains(xLit.get(i2))){
					tmp.add(xLit.get(i2));
					tmpPoint[i] = poit[i2];//将分数也记录下来
					//i2++;
					i++;
				}
				i2++;
				}
			}else if(i1>=recordAssociateNum){//s1已完
				if(!tmp.contains(xLit.get(i2))){
				tmp.add(xLit.get(i2));
				tmpPoint[i] = poit[i2];//将分数也记录下来
				//i2++;
				i++;
				}
				i2++;
			}
	
		}//end for
		
		xLit = tmp;
		poit = tmpPoint;
		
	
	}
}
