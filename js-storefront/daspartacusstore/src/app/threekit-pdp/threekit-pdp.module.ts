import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ThreekitImageCompComponent } from './threekit-image-comp/threekit-image-comp.component';
import { CmsConfig, ConfigModule } from '@spartacus/core';

@NgModule({
  declarations: [ThreekitImageCompComponent],
  imports: [
    CommonModule/*,
    ConfigModule.withConfig({
       cmsComponents: {
         ProductImagesComponent:{
           component: ThreekitImageCompComponent
         }
       }
     } as CmsConfig)*/
  ]
})
export class ThreekitPdpModule { }
