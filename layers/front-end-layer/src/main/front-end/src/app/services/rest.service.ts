import {AuthHttp} from "angular2-jwt";
import {environment} from '../../environments/environment';

export abstract class RestService<T> {
  protected baseUrl: string = environment.baseUrl;
  constructor(protected endPoint: string, protected authHttp: AuthHttp) {
    this.baseUrl += endPoint;
  }
}
