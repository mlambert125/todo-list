export default {
    getCurrentUser: async () => {
        const result = await fetch('/user/');
        return await result.json();
    },
};
