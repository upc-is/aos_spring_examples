export interface AuthenticateResponse {
  id: number;
  username: string;
  email: string;
  roles: string[];
  token: string;
}
