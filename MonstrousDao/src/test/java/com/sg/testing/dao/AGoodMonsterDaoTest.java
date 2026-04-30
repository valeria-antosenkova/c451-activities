package com.sg.testing.dao;

import com.sg.testing.dao.implementations.AGoodMonsterDao;

/**
 * Tests AGoodMonsterDao — all base tests should pass.
 */
public class AGoodMonsterDaoTest extends com.sg.testing.dao.MonsterDaoTestBase {
    @Override
    protected MonsterDao createDao() {
        return new AGoodMonsterDao();
    }
}


