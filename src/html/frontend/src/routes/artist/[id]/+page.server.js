import * as api from '$lib/api.js';

export async function load({ locals, params }) {
    const artist = await api.get(`artist/${params.id}`);
    return { artist };
}