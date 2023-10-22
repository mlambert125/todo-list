<script>
import listService from '../services/list-service';
import userService from '../services/user-service';

export default {
  name: 'HomeView',
  data() {
    return {
      userInfo: null,
      lists: [],
      newListName: ''
    };
  },
  async created() {
    this.userInfo = await userService.getCurrentUser();
    this.lists = await listService.getLists();
  },
  methods: {
    async createList() {
      if (this.newListName === '') return;
      await listService.createList(
        {
          name: this.newListName
        }
      );
      this.lists = await listService.getLists();
    },
    async deleteList(id) {
      await listService.deleteList(id);
      this.lists = await listService.getLists();
    }
  }  
};
</script>

<template>
  <main>
    <h1>Todo List</h1>

    <div v-if="userInfo != null">
      {{ userInfo.principal.attributes.email }}
    </div>

    <ul>
      <li v-for="list in lists" :key="list.id">
        <RouterLink :to="{ name: 'list-detail', params: { id: list.id } }">
          {{ list.name }}
        </RouterLink>
      </li>
    </ul>

    <input type="text" v-model="newListName"  />
    <button v-on:click="createList()">Create List</button>
  </main>
</template>
