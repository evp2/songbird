<div class="centered">
    <h1>Music Bird</h1>

<!--    <form method="POST" use:enhance>-->
<!--        <label>-->
<!--            Search:-->
<!--            <input type="text" name="query" value={form?.input ?? ''}/>-->
<!--        </label>-->
<!--        <button type="submit">Search</button>-->
<!--    </form>-->
    <Search />
    <div class="results">
        <!--{#if form.data}-->
        <!--    {console.log(form.data)}-->
        <!--    &lt;!&ndash;{#each form.songs as song}&ndash;&gt;-->
        <!--    &lt;!&ndash;    <p>{song}</p>&ndash;&gt;-->
        <!--    &lt;!&ndash;{/each}&ndash;&gt;-->
        <!--{/if}-->
    </div>
</div>

<style>
    .centered {
        max-width: 20em;
        margin: 0 auto;
    }

    label {
        width: 100%;
    }

    input {
        flex: 1;
    }

    span {
        flex: 1;
    }

    button {
        border: none;
        background-size: 1rem 1rem;
        cursor: pointer;
        aspect-ratio: 1;
        opacity: 0.5;
        transition: opacity 0.2s;
    }

    button:hover {
        opacity: 1;
    }


</style>
<script>
    import { enhance } from '$app/forms';
    import Search from "src/lib/components/Search.svelte";

    export let data;
    export let form;
</script>
