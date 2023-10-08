# SongBird

An application that enables searching for Artists, Albums, and Songs.

# How to run
  In order to run the app you will need npm installed and credentials for the Genius API. 
  You can supply the API url and token as environment variables. For instance in IntelliJ open the run configrations and find the "Build and run" heading. 
  
  Then click on the "Modify options" dropdown and make sure "Environment Variables" option is selected. 
  
  This will provide a textbox to enter the envoirnment variables.
  
  Format for Environment Variables(change <API TOKEN> with your token):
    
    APPLICATION_API_TOKEN=<API TOKEN>;
    APPLICATION_API_URL=https://api.genius.com;

  Once this is setup you can run the app. By default the API will be served on localhost:8080.

  To run the frontend for the application, cd to '/src/html/frontend'. Then run:
      
      npm install
      
  This will install any necessary packages for your local enviornment, once this is done run:
      
      npm run dev
  
