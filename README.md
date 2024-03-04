# SongBird

An application that enables search for Lyrics, Artists, Albums.

# How to run
  In order to run the app you will need npm installed and credentials for the [Genius API](https://docs.genius.com). 
  You can supply the API url and token as environment variables. For instance in IntelliJ open the run configrations and find the "Build and run" heading. 
  
  Then click on the "Modify options" dropdown and make sure "Environment Variables" option is selected. 
  
  This will provide a textbox to enter the envoirnment variables.
  
  Format for Environment Variables (change <API_URL> and <API_TOKEN> with your url and token):
    
    APPLICATION_API_TOKEN=<API_TOKEN>;
    APPLICATION_API_URL=<API_URL>;

  Once this is setup you can run the app. By default, the API will be served on localhost:8080.

  To start the frontend for the app:

  ```bash
    cd /src/html/frontend
    
    npm install
  ```

  Once you've cloned the project and installed dependencies with `npm install` (or `pnpm install` or `yarn`), start a development server:

  ```bash
    npm run dev
    
    # or start the server and open the app in a new browser tab
    npm run dev -- --open
  ```
  
