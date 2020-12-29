function threekit_pdp(assetId){
        let targetEl = document.getElementById("player");
        // Auth Tokens are Domain Bound
        let authToken = "0aac3498-bd82-4b70-893a-55d79b300607";
        window.threekitPlayer({
            authToken : authToken,
            el : targetEl,
            assetId : assetId,
            showConfigurator : true,
            showAR : true
            // initialConfiguration : {}
        })
        .then(player=>{
            // Lift the player retured in the promise to the window 
            window.player = player;
            player.getConfigurator().then(conf=>{
                window.configurator = conf;
            });
        });
    }

    async function getAssetId(SKU) {
        
        const url =
          "https://admin.threekit.com/api/catalog/products" +
          `?bearer_token=0aac3498-bd82-4b70-893a-55d79b300607` +
          `&orgId=1ad61135-fdcf-4834-82c1-edf8a1a34a61` +
          `&metadata=${JSON.stringify({ SKU })}` ;
         
      console.log(url);
      console.log("Fetching data...");
        const tkProduct = await fetch(url)
          .then((res) => res.json())
          .then((data) => data.products[0]);
      console.log("Product is:"+tkProduct.id);
      return tkProduct.id;
      }
