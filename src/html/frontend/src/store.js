import {writable} from 'svelte/store';

const createState = () => {
    const {subscribe, set, update} = writable({
        results: null,
        query: null
    });

    return {
        subscribe,
        set: async (results, query) => {
            return set({results, query});
        },
        search: async (query) => {
            set({ results: null, query: query });
            let param = encodeURIComponent(query);
            return await fetch(`http://localhost:8080/search?query=${param}`, {
                method: "GET",
            }).then((response) => response.json());
        },
        update: async (results, query) => {
            return set({results, query});
        },
    };
};
export const state = createState();