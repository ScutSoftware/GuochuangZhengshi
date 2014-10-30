package com.lis.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lis.dao.ComplaintTextDao;
import com.lis.model.ComplaintText;
import com.lis.service.SegmentationService;

@Service("segmentationService")
@Transactional
public class SegmentationServiceImpl implements SegmentationService {

	private ComplaintTextDao complaintTextDao;

	@Autowired
	public void setComplaintTextDao(ComplaintTextDao complaintTextDao) {
		this.complaintTextDao = complaintTextDao;
	}

	// 判断两个字符串是否匹配，采用BM算法
	@Override
	public boolean isMatching(String pattern, String text) {
		char[] t = pattern.toCharArray();
		char[] p = text.toCharArray();
		int plen = p.length, tlen = t.length;
		int sum = 0;
		if (plen < tlen) {
			return false;
		} 
		else{
			int i = tlen, k, j;

			while (i <= plen) {
				k = i;
				j = tlen;
				
				while (j > 0 && p[i - 1] == t[j - 1]) {
					i--;
					j--;
				}
				
				if (0 == j) {
					sum = sum + tlen;
					return true;
				} 
				else {
					sum = sum + k - (i - 1);
					i = i + dist(p[i - 1], t);

					if (i > plen) {
						return false;
					}
				}
			}
		}
		return false;
	}

	private int dist(char c, char T[]) {
		int n = T.length;
		
		if (c == T[n - 1]) {
			return n;
		}

		for (int i = n; i >= 1; i--) {
			if (T[i - 1] == c)
				return n - i;
		}

		return n;
	}


	//从数据库中获取所有的文本记录
	@Override
	public List<ComplaintText> getTextRecords() {
		// TODO Auto-generated method stub
		try {
			List<ComplaintText> list = complaintTextDao.list();
			return list;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}

	//获取和关键词匹配的文本记录
	@Override
	public List<String> getMatchingTexts(List<ComplaintText> list, String[] keyWords) {
		// TODO Auto-generated method stub
		try {
			int keyWordsCount = keyWords.length;
			List<String> results = new ArrayList<String>();
			
			//对于每个文本记录，都和指定关键词匹配一下，记录匹配次数在matchCount中
			for(int i = 0 ; i < list.size(); i ++){
				String complaintTextTemp = list.get(i).getComplaintContent();
				int matchCount = 0;
				for(int j = 0; j < keyWords.length; j ++){
					if(isMatching(keyWords[j],complaintTextTemp)){
						matchCount++;
					}
				}
				
				//比较是否全部匹配，是则放入结果中
				if(matchCount == keyWordsCount){
					results.add(complaintTextTemp);
				}
			}		
			return results;
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
		
	}
	
	
}
