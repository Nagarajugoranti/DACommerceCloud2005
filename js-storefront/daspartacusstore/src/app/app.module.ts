import { BrowserModule, BrowserTransferStateModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { translations, translationChunksConfig } from '@spartacus/assets';
import { B2cStorefrontModule } from '@spartacus/storefront';
import { environment } from '../environments/environment';
import { OccConfig } from '@spartacus/core';
import { ThreekitPdpModule } from './threekit-pdp/threekit-pdp.module';


const occConfig: OccConfig = { backend: { occ: {} } };
if (environment.occBaseUrl) {
  occConfig.backend.occ.baseUrl = environment.occBaseUrl;
}
if (environment.prefix) {
  occConfig.backend.occ.prefix = environment.prefix;
}
else {
  occConfig.backend.occ.prefix = '/occ/v2/';
}

@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule.withServerTransition({ appId: 'serverApp' }),
    B2cStorefrontModule.withConfig({
      backend: {
        occ: {
        
         baseUrl: occConfig.backend.occ.baseUrl,
          prefix: occConfig.backend.occ.prefix
        }
      },
      context: {
        //urlParameters: ['baseSite', 'language', 'currency'],
        baseSite: ['electronicsda-spa']
       // currency: ['USD', 'JPY']
      },
      i18n: {
        resources: translations,
        chunks: translationChunksConfig,
        fallbackLang: 'en'
      },
      features: {
        level: '2.1'
      }
    }),
    BrowserTransferStateModule,
    ThreekitPdpModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { 
  
}
