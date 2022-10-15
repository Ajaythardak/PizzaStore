import { TestBed } from '@angular/core/testing';

import { LoggedInCheckGuard } from './logged-in-check.guard';

describe('LoggedInCheckGuard', () => {
  let guard: LoggedInCheckGuard;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    guard = TestBed.inject(LoggedInCheckGuard);
  });

  it('should be created', () => {
    expect(guard).toBeTruthy();
  });
});
