import { TestBed } from '@angular/core/testing';

import { UserService } from '../../../../../../../../../../../../iCloud/Development/2102/si652/sandbox/security-center-client/src/app/users/services/user.service';

describe('UserService', () => {
  let service: UserService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(UserService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
