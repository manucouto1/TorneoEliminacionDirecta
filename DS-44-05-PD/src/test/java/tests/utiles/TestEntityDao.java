package tests.utiles;

import new_tech_dev.development.base_dao.BaseTestDao;
import new_tech_dev.development.base_entity.TestEntity;

public interface TestEntityDao extends BaseTestDao<TestEntity>{
	public void cleanDb();
}	
