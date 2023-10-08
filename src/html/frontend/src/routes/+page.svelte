<div class="navbar bg-base-100">
    <div>
        <Fa icon={faDove} />
        <a class="text-xl px-2" href="/search">SongBird</a>
    </div>
</div>
<div class="hero min-h-screen bg-base-100" style="margin: auto;width: 50%;">
    <div class="hero-content text-center">
        <div class="max-w-md flex flex-col">
            <div>
                <h1 class="text-xl font-bold">SongBird Application</h1>
            </div>
            <div class="py-6">
                <p>An application that enables searching for Artists, Albums, and Songs.</p>
                <br>
                <p>By Evan Pomponio</p>
            </div>
            <div>
                <p class="py-6">Technologies:</p>
            </div>
            <div>
                <ul>
                    <li>Spring Boot</li>
                    <li>SvelteKit</li>
                    <li>Genius API</li>
                </ul>
                <br>
            </div>
            <div>
                <a class="btn btn-primary" href="/search">Get Started</a>
            </div>
        </div>
    </div>
</div>
<script>
    import Fa from 'svelte-fa';
    import {faDove} from "@fortawesome/free-solid-svg-icons";
</script>
