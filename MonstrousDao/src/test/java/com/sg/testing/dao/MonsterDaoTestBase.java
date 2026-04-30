package com.sg.testing.dao;

import com.sg.testing.model.Monster;
import com.sg.testing.model.MonsterType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Abstract base test class for MonsterDao.
 * Every test here must pass for ALL correct DAO implementations.
 * Each Bad DAO subclass extends this and adds one extra targeted test
 * that exposes that specific DAO's bug.
 */
public abstract class MonsterDaoTestBase {

    protected MonsterDao dao;

    // Each subclass returns its specific DAO implementation
    protected abstract MonsterDao createDao();

    @BeforeEach
    public void setUp() {
        dao = createDao();
    }

    // ─────────────────────────────────────────
    //  Helper: creates a sample monster
    // ─────────────────────────────────────────
    protected Monster makeMonster(String name) {
        return new Monster(name, MonsterType.YETI, 3, "Brains");
    }

    // ─────────────────────────────────────────
    //  addMonster tests
    // ─────────────────────────────────────────

    @Test
    public void testAddMonsterReturnsNullWhenIdNew() {
        Monster m = makeMonster("Dracula");
        Monster previous = dao.addMonster(1, m);
        assertNull(previous, "Adding to a new id should return null");
    }

    @Test
    public void testAddMonsterReturnsPreviousWhenIdExists() {
        Monster first  = makeMonster("Dracula");
        Monster second = makeMonster("Frankenstein");
        dao.addMonster(1, first);
        Monster previous = dao.addMonster(1, second);
        assertEquals(first, previous, "Adding to existing id should return the old monster");
    }

    @Test
    public void testAddMonsterStoresUnderCorrectId() {
        Monster m = makeMonster("Wolfman");
        dao.addMonster(42, m);
        assertEquals(m, dao.getMonster(42), "Monster should be retrievable by the id it was added under");
    }

    @Test
    public void testAddTwoMonstersAreBothStored() {
        dao.addMonster(1, makeMonster("Dracula"));
        dao.addMonster(2, makeMonster("Mummy"));
        assertEquals(2, dao.getAllMonsters().size(), "Both monsters should be stored separately");
    }

    // ─────────────────────────────────────────
    //  getMonster tests
    // ─────────────────────────────────────────

    @Test
    public void testGetMonsterReturnsCorrectMonster() {
        Monster m = makeMonster("Dracula");
        dao.addMonster(1, m);
        assertEquals(m, dao.getMonster(1));
    }

    @Test
    public void testGetMonsterReturnsNullWhenNotFound() {
        assertNull(dao.getMonster(99), "Getting a non-existent id should return null");
    }

    @Test
    public void testGetMonsterDoesNotRemoveItFromStorage() {
        Monster m = makeMonster("Dracula");
        dao.addMonster(1, m);
        dao.getMonster(1);  // call once
        assertEquals(m, dao.getMonster(1), "Monster should still be there after a get");
    }

    @Test
    public void testGetMonsterDoesNotCorruptStoredValue() {
        Monster m = makeMonster("Dracula");
        dao.addMonster(1, m);
        Monster retrieved = dao.getMonster(1);
        assertEquals(m, retrieved, "getMonster should not alter the stored monster");
    }

    // ─────────────────────────────────────────
    //  getAllMonsters tests
    // ─────────────────────────────────────────

    @Test
    public void testGetAllMonstersEmptyWhenNoneAdded() {
        List<Monster> all = dao.getAllMonsters();
        assertNotNull(all, "getAllMonsters should never return null");
        assertTrue(all.isEmpty(), "Should be empty before anything is added");
    }

    @Test
    public void testGetAllMonstersReturnsAllAdded() {
        dao.addMonster(1, makeMonster("Dracula"));
        dao.addMonster(2, makeMonster("Mummy"));
        dao.addMonster(3, makeMonster("Wolfman"));
        assertEquals(3, dao.getAllMonsters().size(), "getAllMonsters should return all 3 monsters");
    }

    @Test
    public void testGetAllMonstersNoDuplicates() {
        dao.addMonster(1, makeMonster("Dracula"));
        dao.addMonster(2, makeMonster("Mummy"));
        List<Monster> all = dao.getAllMonsters();
        assertEquals(2, all.size(), "getAllMonsters must not return duplicates");
    }

    // ─────────────────────────────────────────
    //  updateMonster tests
    // ─────────────────────────────────────────

    @Test
    public void testUpdateMonsterChangesStoredValue() {
        Monster original = makeMonster("Dracula");
        Monster updated  = makeMonster("Super Dracula");
        dao.addMonster(1, original);
        dao.updateMonster(1, updated);
        assertEquals(updated, dao.getMonster(1), "Monster should reflect the update");
    }

    @Test
    public void testUpdateMonsterOnNonExistentIdDoesNotAddNewEntry() {
        dao.updateMonster(99, makeMonster("Ghost"));
        assertTrue(dao.getAllMonsters().isEmpty(),
                "Updating a non-existent id should not add a new monster");
    }

    // ─────────────────────────────────────────
    //  removeMonster tests
    // ─────────────────────────────────────────

    @Test
    public void testRemoveMonsterReturnsRemovedMonster() {
        Monster m = makeMonster("Dracula");
        dao.addMonster(1, m);
        Monster removed = dao.removeMonster(1);
        assertEquals(m, removed, "removeMonster should return the removed monster");
    }

    @Test
    public void testRemoveMonsterActuallyRemovesIt() {
        dao.addMonster(1, makeMonster("Dracula"));
        dao.removeMonster(1);
        assertNull(dao.getMonster(1), "Monster should be gone after removal");
    }

    @Test
    public void testRemoveMonsterReturnsNullWhenNotFound() {
        assertNull(dao.removeMonster(99), "Removing non-existent id should return null");
    }
}


