<script>
import listService from '../services/list-service';
import listItemService from '../services/list-item-service';
import userService from '../services/user-service';

export default {
  name: 'ListDetailView',
  data() {
    return {
      userInfo: null,
      listItems: []      
    };
  },
  async created() {
    this.userInfo = await userService.getCurrentUser();
    this.listItems = await listItemService.getListItemsByListId(this.$route.params.id);
  },
};
</script>

<template>
  <main>
    <ul>
      <li v-for="listItem in listItems" :key="listItem.id">
        {{ listItem.name }}
      </li>
    </ul>
  </main>
</template>
