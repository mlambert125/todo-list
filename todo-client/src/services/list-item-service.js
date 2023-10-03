export default {
    getListItemsByListId: async (listId) => {
        const result = 
            await fetch(`/listItem/${listId}` );
        return await result.json();            
    },
    createListItem: async (listItem) => {
        const result = 
            await fetch(
                '/listItem/', 
                {
                    method: 'POST',
                    headers: {
                        'Content-Type': 'application/json'
                    },
                    body: JSON.stringify(listItem)
                }
            );
        return await result.json();
    },
    deleteListItem: async (listId, listItemId) => {
        const result = 
            await fetch(`/listItem/${listId}/${listItemId}`,  { method: 'DELETE' });
        return await result.json();
    },
    completeListItem: async (listId, listItemId) => {
        const result = 
            await fetch(`/listItem/complete/${listId}/${listItemId}`,  { method: 'PUT' });
        return await result.json();
    },
    uncompleteListItem: async (listId, listItemId) => {
        const resula = await fetch(`/listItem/uncomplete/${listId}/${listItemId}`,  { method: 'PUT' });

        return await result.json();
    }
};
