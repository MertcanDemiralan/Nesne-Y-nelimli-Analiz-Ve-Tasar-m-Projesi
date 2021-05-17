--
-- PostgreSQL database dump
--

-- Dumped from database version 12.1
-- Dumped by pg_dump version 12rc1

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- Name: SmartDeviceDB; Type: DATABASE; Schema: -; Owner: postgres
--

CREATE DATABASE "SmartDeviceDB" WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'English_United States.1252' LC_CTYPE = 'English_United States.1252';


ALTER DATABASE "SmartDeviceDB" OWNER TO postgres;

\connect "SmartDeviceDB"

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- Name: Device; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."Device" (
    id integer NOT NULL,
    open boolean
);


ALTER TABLE public."Device" OWNER TO postgres;

--
-- Name: Temperature; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."Temperature" (
    id integer NOT NULL,
    value double precision
);


ALTER TABLE public."Temperature" OWNER TO postgres;

--
-- Name: User; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."User" (
    username character varying(128),
    password character varying(128)
);


ALTER TABLE public."User" OWNER TO postgres;

--
-- Data for Name: Device; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public."Device" (id, open) VALUES (1, false);


--
-- Data for Name: Temperature; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public."Temperature" (id, value) VALUES (1, 5.281133364040946);


--
-- Data for Name: User; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public."User" (username, password) VALUES ('user', '123456');


--
-- Name: Device Device_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Device"
    ADD CONSTRAINT "Device_pkey" PRIMARY KEY (id);


--
-- Name: Temperature Temperature_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Temperature"
    ADD CONSTRAINT "Temperature_pkey" PRIMARY KEY (id);


--
-- PostgreSQL database dump complete
--

