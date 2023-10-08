<div class="navbar bg-base-100">
    <div>
        <Fa icon={faDove} />
        <a class="text-xl px-2" href="#">SongBird</a>
    </div>
</div>
<div class="flex my-6 space-x-8" style="margin: auto;width: 80%;">
    {#if data.artist}
        <div class="flex flex-col space-y-4">
            <div class="w-48 h-48">
                <img src={data.artist.imageUrl} />
            </div>
            <div>
                <h2 class="text-xl">{data.artist.name}</h2>
            </div>
            <div class="flex flex-row space-x-4">
                {#if data.artist.facebookName.toString() !== "null"}
                    <div class="tooltip" data-tip={data.artist.facebookName}>
                        <Fa icon={faFacebook} />
                    </div>
                {/if}
                {#if data.artist.instagramName.toString() !== "null"}
                    <div class="tooltip" data-tip={data.artist.instagramName}>
                        <Fa icon={faInstagram} />
                    </div>
                {/if}
                {#if data.artist.twitterName.toString() !== "null"}
                    <div class="tooltip" data-tip={data.artist.twitterName}>
                        <Fa icon={faTwitter} />
                    </div>
                {/if}
            </div>
            {#if data.artist.alternateNames}
                <div>
                    <p>Alternate Names:</p>
                    <p>{data.artist.alternateNames}</p>
                </div>
            {/if}
        </div>
        <div>
            {#if data.artist.description && data.artist.description.toString().length > 15}
                <div class="description">
                    {@html data.artist.description}
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
    .description :global(a) {
        color: darkslategray;
        text-decoration: underline;
    }
</style>
<script>
    import Fa from 'svelte-fa';
    import {faDove} from "@fortawesome/free-solid-svg-icons";
    import {faFacebook} from "@fortawesome/free-brands-svg-icons";
    import {faInstagram} from "@fortawesome/free-brands-svg-icons";
    import {faTwitter} from "@fortawesome/free-brands-svg-icons";

    export let data;

</script>