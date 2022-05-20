import { NgModule } from "@angular/core";
import { AgencyPipe } from "./pipes/agency.pipe";
import { OperationPipe } from "./pipes/operation.pipe";

@NgModule({
    declarations: [
        AgencyPipe,
        OperationPipe,
    ],
    exports: [
        AgencyPipe,
        OperationPipe,
    ]
})
export class SharedModule {}
