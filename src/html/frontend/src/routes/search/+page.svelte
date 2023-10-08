<div class="navbar bg-base-100">
    <div>
        <Fa icon={faDove} />
        <a class="text-xl px-2">SongBird</a>

        <form on:submit|preventDefault={handleSubmit}>
            <input type="text" name="query" class="input input-bordered" bind:value={input} />
            <button class="btn" type="submit">Search</button>
        </form>
    </div>
    {#if loadingState}
        <div>
            <Fa icon={faSpinner} size="3x" pulse />
        </div>
    {/if}
</div>

{#if searchResults}
    <div class="overflow-x-auto">
        <table class="table mx-8">
            <thead>
                <tr>
                    <th>
                        Artwork
                    </th>
                    <th>
                        Artist
                    </th>
                    <th>
                        Title
                    </th>
                    <th>
                        Release Date
                    </th>
                    <th>
                        Featured Artist(s)
                    </th>
                </tr>
            </thead>
                {#each searchResults as result}
                    <tbody>
                        <tr>
                            <td>
                                <div class="flex items-center space-x-3">
                                    <div class="thumbnail">
                                        <div class="w-24 h-24">
                                            <img src={result.thumbnail} />
                                        </div>
                                    </div>
                                </div>
                            </td>
                            <td>
                                <a class="btn btn-ghost btn-xs" href="/artist/{result.artistId}">{result.artistName}</a>
                            </td>
                            <td>
                                <a class="btn btn-ghost btn-xs" href="/songs/{result.songId}">{result.songTitle}</a>
                            </td>
                            <td>
                                {result.releaseDate}
                            </td>
                            <td>
                                {#if result.featuredArtists.length > 0}
                                    <div class="badge badge-outline">
                                        {result.featuredArtists}
                                    </div>
                                {/if}
                            </td>
                        </tr>
                    </tbody>
                {/each}
        </table>
    </div>
{/if}
<script>
    import Fa from 'svelte-fa';
    import {state} from '../../store';
    import {faSpinner} from "@fortawesome/free-solid-svg-icons";
    import {faDove} from "@fortawesome/free-solid-svg-icons";

    let loadingState = false;
    let searchResults;
    let input;
    state.subscribe((value) => {
        if (value !== null) {
            if (value.query !== null) {
                input = value.query;
            }
            if (value.results !== null) {
                console.log(value.results);
            }
        }
    });
    const handleSubmit = async (event) => {
        event.preventDefault();
        loadingState = true;
        try {
            let response = await state.search(input);
            //console.log(response);
            searchResults = [];
            response.songs.forEach((song) => {
                searchResults.push({
                    artistId: song.artistId,
                    songTitle: song.songTitle,
                    songId: song.songId,
                    releaseDate: song.releaseDate,
                    thumbnail: song.thumbnail,
                    artistName: song.artistName,
                    featuredArtists: song.featuredArtists
                });

            });
            loadingState = false;
        } catch (error) {
            loadingState = false;
            alert(error.message);
        }
    };
</script>
