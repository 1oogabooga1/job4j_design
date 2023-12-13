package ru.job4j.generic;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class RoleStoreTest {
    @Test
    void whenAddAndFindThenUsernameIsDmitrii() {
        RoleStore store = new RoleStore();
        store.add(new Role("2", "Dmitrii"));
        Role result = store.findById("2");
        assertThat(result.getUsername()).isEqualTo("Dmitrii");
    }

    @Test
    void whenAddAndFindThenUserIsNull() {
        RoleStore store = new RoleStore();
        store.add(new Role("5", "Dmitrii"));
        Role result = store.findById("10");
        assertThat(result).isNull();
    }

    @Test
    void whenAddDuplicateAndFindUsernameIsDmitrii() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Dmitrii"));
        store.add(new Role("1", "Maxim"));
        Role result = store.findById("1");
        assertThat(result.getUsername()).isEqualTo("Dmitrii");
    }

    @Test
    void whenReplaceThenUsernameIsEgor() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Dmitrii"));
        store.replace("1", new Role("1", "Egor"));
        Role result = store.findById("1");
        assertThat(result.getUsername()).isEqualTo("Egor");
    }

    @Test
    void whenNoReplaceUserThenNoChangeUsername() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Dmitrii"));
        store.replace("10", new Role("10", "Ivan"));
        Role result = store.findById("1");
        assertThat(result.getUsername()).isEqualTo("Dmitrii");
    }

    @Test
    void whenDeleteUserThenUserIsNull() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Dmitrii"));
        store.delete("1");
        Role result = store.findById("1");
        assertThat(result).isNull();
    }

    @Test
    void whenNoDeleteUserThenUsernameIsDmitrii() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Dmitrii"));
        store.delete("10");
        Role result = store.findById("1");
        assertThat(result.getUsername()).isEqualTo("Dmitrii");
    }

    @Test
    void whenReplaceOkThenTrue() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Dmitrii"));
        boolean result = store.replace("1", new Role("1", "Konstantin"));
        assertThat(result).isTrue();
    }

    @Test
    void whenReplaceNotOkThenFalse() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Dmitrii"));
        boolean result = store.replace("10", new Role("10", "Stepan"));
        assertThat(result).isFalse();
    }

}