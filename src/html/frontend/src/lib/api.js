
const base = 'http://localhost:8080';

async function send({ method, path, data}) {
    const opts = { method, headers: {} };
    opts.headers['Content-Type'] = 'application/json';
    // if (data) {
    //     opts.headers['Content-Type'] = 'application/json';
    //     opts.body = JSON.stringify(data);
    // }

    const res = await fetch(`${base}/${path}`, opts);
    if (res.ok || res.status === 422) {
        return res.json();
    }

    throw error(res.status);
}

export function get(path, token) {
    return send({ method: 'GET', path });
}
