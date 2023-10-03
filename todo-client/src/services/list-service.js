export default {
    getLists: async () => {
        const result = await fetch('/list/');
        return await result.json();
    },
    createList: async (list) => {
        const result = 
            await fetch(
                '/list/', 
                {
                    method: 'POST',
                    headers: {
                        'Content-Type': 'application/json'
                    },
                    body: JSON.stringify(list)
                }
            );
        return await result.json();
    },
    deleteList: async (listId) => {
        const result = 
            await fetch(`/list/${listId}`,  { method: 'DELETE' });
        return await result.json();
    },
    updateList: async (list) => {
        const result = 
            await fetch(
                `/list/${list.id}`, 
                { 
                    method: 'PUT',
                    headers: {
                        'Content-Type': 'application/json'
                    },
                    body: JSON.stringify(list)
                }
            );
        return await result.json();
    }
};
