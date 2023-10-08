<div class="navbar bg-base-100">
    <div>
        <Fa icon={faDove} />
        <a class="text-xl px-2" href="#">SongBird</a>
    </div>
</div>
<div class="flex my-6 space-x-8" style="margin: auto;width: 80%;">
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
                <p class="info"><b>Album:</b>&nbsp;{data.song.album}</p>
            </div>
            <div>
                <p class="info"><b>Release Date:</b>&nbsp;{data.song.releaseDate}</p>
            </div>
            {#if data.song.featuredArtists.toString() > 0}
                <div>
                    <p><b>Featuring:</b>&nbsp;{data.song.featuredArtists}</p>
                </div>
            {/if}
        </div>
        <div>
            {#if data.song.description && data.song.description.toString().length > 15}
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
    .info {
        white-space: nowrap;
    }
    .description :global(a) {
        color: darkslategray;
        text-decoration: underline;
    }
</style>
<script>
    import Fa from 'svelte-fa';
    import {faDove} from "@fortawesome/free-solid-svg-icons";
    export let data;

</script>