INSERT INTO korisnik (id, e_mail, korisnicko_ime, lozinka, ime, prezime, uloga)
              VALUES (1,'miroslav@maildrop.cc','miroslav','$2y$12$NH2KM2BJaBl.ik90Z1YqAOjoPgSd0ns/bF.7WedMxZ54OhWQNNnh6','Miroslav','Simic','ADMIN');
INSERT INTO korisnik (id, e_mail, korisnicko_ime, lozinka, ime, prezime, uloga)
              VALUES (2,'tamara@maildrop.cc','tamara','$2y$12$DRhCpltZygkA7EZ2WeWIbewWBjLE0KYiUO.tHDUaJNMpsHxXEw9Ky','Tamara','Milosavljevic','KORISNIK');
INSERT INTO korisnik (id, e_mail, korisnicko_ime, lozinka, ime, prezime, uloga)
              VALUES (3,'petar@maildrop.cc','petar','$2y$12$i6/mU4w0HhG8RQRXHjNCa.tG2OwGSVXb0GYUnf8MZUdeadE4voHbC','Petar','Jovic','KORISNIK');

INSERT INTO reprezentacija (id, naziv, skraceni_naziv) VALUES (1, "Serbia", "SRB");
INSERT INTO reprezentacija (id, naziv, skraceni_naziv) VALUES (2, "Croatia", "CRO");
INSERT INTO reprezentacija (id, naziv, skraceni_naziv) VALUES (3, "Brasil", "BRA");
INSERT INTO reprezentacija (id, naziv, skraceni_naziv) VALUES (4, "England", "ENG");
INSERT INTO reprezentacija (id, naziv, skraceni_naziv) VALUES (5, "Spain", "ESP");

INSERT INTO igrac(id, ime, prezime, br_golova, reprezentacija_id) VALUES (1, "Aleksandar", "Mitrović", 3, 1);
INSERT INTO igrac(id, ime, prezime, br_golova, reprezentacija_id) VALUES (2, "Sergio", "Ramos", 2, 5);
INSERT INTO igrac(id, ime, prezime, br_golova, reprezentacija_id) VALUES (3, "Roberto", "Carlos", 1, 3);
INSERT INTO igrac(id, ime, prezime, br_golova, reprezentacija_id) VALUES (4, "Harry", "Kane", 3, 4);
INSERT INTO igrac(id, ime, prezime, br_golova, reprezentacija_id) VALUES (5, "Luka", "Modrić", 3, 2);

INSERT INTO utakmica (id, reprezentacija_a_id, reprezentacija_b_id, golovi_tima, golovi_timb) 
			  VALUES (1, 1, 5, 5, 1);
INSERT INTO utakmica (id, reprezentacija_a_id, reprezentacija_b_id, golovi_tima, golovi_timb) 
			  VALUES (2, 3, 4, 2, 0);
INSERT INTO utakmica (id, reprezentacija_a_id, reprezentacija_b_id, golovi_tima, golovi_timb) 
			  VALUES (3, 5, 1, 1, 2);
INSERT INTO utakmica (id, reprezentacija_a_id, reprezentacija_b_id, golovi_tima, golovi_timb) 
			  VALUES (4, 4, 3, 4, 3);
INSERT INTO utakmica (id, reprezentacija_a_id, reprezentacija_b_id, golovi_tima, golovi_timb) 
			  VALUES (5, 2, 4, 1, 5);