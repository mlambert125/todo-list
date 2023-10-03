<script>
import listService from '../services/list-service';
import userService from '../services/user-service';

export default {
  name: 'HomeView',
  data() {
    return {
      userInfo: null,
      lists: []
    };
  },
  async created() {
    this.userInfo = await userService.getCurrentUser();
    this.lists = await listService.getLists();
  },
};
</script>

<template>
  <main>
    <h1>Home</h1>

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

  </main>
</template>
