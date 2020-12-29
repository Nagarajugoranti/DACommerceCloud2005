import { Component,OnInit } from '@angular/core';
import { BehaviorSubject, Observable } from 'rxjs';
import { CurrentProductService } from '@spartacus/storefront';
import { Product } from '@spartacus/core';

declare function getAssetId(SKU: any): any;
declare function threekit_pdp(id: any): any;
@Component({
  selector: 'app-threekit-image-comp',
  templateUrl: './threekit-image-comp.component.html',
  styleUrls: ['./threekit-image-comp.component.scss']
})
export class ThreekitImageCompComponent implements OnInit {
 product$: Observable<Product> = this.currentProductService.getProduct();
 sub: any;
 productid: String = "" ;
  constructor(private currentProductService: CurrentProductService) { 

  }
  ngOnInit(): void {
    this.sub = this.product$.subscribe(product => {
      this.productid = getAssetId(product.code);
    })
  }
  ngOnDestroy() {
    this.sub?.unsubscribe();
  }

}
