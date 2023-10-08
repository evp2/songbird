<div class="navbar bg-base-100">
    <div>
        <Fa icon={faDove} />
        <a class="text-xl px-2">SongBird</a>
    </div>
</div>
<div class="grid grid-cols-2 mx-10 my-6">
    {#if data.song}
        <div class="flex flex-col space-y-4">
            <div class="w-48 rounded-full">
                <img src={data.song.thumbnail} />
            </div>
            <div>
                <h2 class="text-xl">{data.song.title}</h2>
            </div>
            <div>
                <p>{data.song.primaryArtist}</p>
            </div>
            <div>
                <p>{data.song.album}</p>
            </div>
            <div>
                <p>{data.song.releaseDate}</p>
            </div>
            {#if data.song.featuredArtists}
                <div>
                    <p>{data.song.featuredArtists}</p>
                </div>
            {/if}
        </div>
        <div>
            {#if data.song.description}
                <div class="description">
                    {@html data.song.description}
                </div>
            {/if}
        </div>
    {/if}
</div>
<style>
    .description {
        border-radius: 25px;
        background: lightgray;
        padding: 20px;
    }
    .description :global(p) {
        text-indent: 25px;
    }
</style>
<script>
    import Fa from 'svelte-fa';
    import {faDove} from "@fortawesome/free-solid-svg-icons";
    export let data;

</script>