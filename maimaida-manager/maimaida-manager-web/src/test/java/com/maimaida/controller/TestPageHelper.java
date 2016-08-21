package com.maimaida.controller;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.maimaida.mapper.TbItemMapper;
import com.maimaida.po.TbItem;
import com.maimaida.po.TbItemExample;

public class TestPageHelper {

	@Test
	public void testPageHelper() {
		// ����һ��spring����
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-*");
		// ��spring�����л�ȡmapper�������
		TbItemMapper mapper = context.getBean(TbItemMapper.class);
		// ִ�в�ѯ����ҳ
		TbItemExample example = new TbItemExample();
		//��ҳ����
		PageHelper.startPage(2, 10);
		List<TbItem> list = mapper.selectByExample(example);
		// ȡ��Ʒ�б�
		for(TbItem item : list) {
			System.out.println(item.getTitle());
		}
		// ȡ��ҳ��Ϣ
		PageInfo<TbItem> pageInfo = new PageInfo<TbItem>(list);
		long total = pageInfo.getTotal();
		System.out.println("������Ʒ��Ϣ��" + total);
	}
}
