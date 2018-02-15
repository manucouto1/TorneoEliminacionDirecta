package tests.utiles;

import new_tech_dev.development.base_shit.base_dao.BaseTestDao;
import new_tech_dev.development.base_shit.base_entity.TestEntity;

public interface TestEntityDao extends BaseTestDao<TestEntity,Void>{
	public void cleanDb();
}	
