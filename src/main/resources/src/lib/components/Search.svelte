<div>

    <label>
        Search:
        <input type="text" name="query" value={query}/>
    </label>
    <button type="submit" on:click={search(query)}>Search</button>

</div>

<script>
    let query = "";
    let results;

    const search = async () => {
        let param = encodeURIComponent(query);
        results =  await fetch(`http://localhost:8080/search?query=${param}`, {
            method: "GET",
            mode: "no-cors",
            headers: {
                "Allow-Control-Allow-Origin": "http://localhost:8080"
            }
        });
        if (results) {
            results = results.json()
        }
    }

</script>