import * as api from '$lib/api.js';

export async function load({ locals, params }) {
    const song = await api.get(`songs/${params.id}`);
    return { song };
}