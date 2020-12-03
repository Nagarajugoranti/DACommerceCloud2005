import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ThreekitImageCompComponent } from './threekit-image-comp/threekit-image-comp.component';
import { CmsComponent, CmsConfig, ConfigModule } from '@spartacus/core';



@NgModule({
  declarations: [ThreekitImageCompComponent],
  imports: [
    CommonModule/*,
    ConfigModule.withConfig({
      cmsComponents: {
        /*ProductImagesComponent:{
          component: ThreekitImageCompComponent*/
       /* }
        /*,
        ProductIntroComponent:{
          component: ThreekitImageCompComponent
        }*/
      /*}
    } as CmsConfig)*/
  ]
})
export class ThreekitPdpModule { }
