package jp.hannet.sample.service;

import static org.junit.Assert.*;

import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import jp.hannet.sample.model.Employee;

public class EmployeeServiceImpTest {

	private IEmployeeService service;

	private final static int TEST_ID = 1;

	@Before
	public void setUp() throws Exception {
		@SuppressWarnings("resource")
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:/spring.xml");
		service = (IEmployeeService) ctx.getBean(IEmployeeService.class);
	}

	@Test
	public void testSelectById() {
		Employee map = service.selectById(TEST_ID);
		assertNotNull(map);
	}

	@Test
	public void testSelectAll() {
		List<Employee> map = service.selectAll();
		assertNotEquals(0, map.size());
	}

	@Test
	public void testSaveAndDelete() {
		// ランダムな10個の文字列生成
		String name = RandomStringUtils.randomAscii(10);
		String enumber = RandomStringUtils.randomAscii(10);
		Employee map = new Employee();
		map.setName(name);
		map.setEnumber(enumber);
		// DBに書き込む
		service.save(map);

		int saveId = map.getId();
		// DBからIDで取得
		Employee mapre = service.selectById(map.getId());

		// 書き込んだデータが取得できているか検証
		assertEquals(name, mapre.getName());
		assertEquals(enumber, mapre.getEnumber());

		// テストが終わったらゴミデータ削除
		service.delete(map);

		// DBからIDで取得
		Employee deleteMap = service.selectById(saveId);
		assertEquals(null, deleteMap);
	}

	@Test
	public void testUpdate() {
		Employee map = service.selectById(TEST_ID);
		String name = RandomStringUtils.randomAscii(10);
		String enumber = RandomStringUtils.randomAscii(10);
		map.setName(name);
		map.setEnumber(enumber);
		service.update(map);

		Employee updatemap = service.selectById(TEST_ID);

		assertEquals(name, updatemap.getName());
		assertEquals(enumber, updatemap.getEnumber());
	}
}
