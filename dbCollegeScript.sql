--
-- PostgreSQL database dump
--

-- Dumped from database version 11.11
-- Dumped by pg_dump version 11.11

-- Started on 2021-03-03 02:56:27

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

SET default_with_oids = false;

--
-- TOC entry 197 (class 1259 OID 24579)
-- Name: groups; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.groups (
    id integer NOT NULL,
    name character varying(10)
);


ALTER TABLE public.groups OWNER TO postgres;

--
-- TOC entry 199 (class 1259 OID 24595)
-- Name: students; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.students (
    id integer NOT NULL,
    firstname character varying(30),
    lastname character varying(30),
    age integer,
    points integer,
    groupnum integer
);


ALTER TABLE public.students OWNER TO postgres;

--
-- TOC entry 196 (class 1259 OID 24577)
-- Name: tgroups_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.tgroups_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.tgroups_id_seq OWNER TO postgres;

--
-- TOC entry 2830 (class 0 OID 0)
-- Dependencies: 196
-- Name: tgroups_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.tgroups_id_seq OWNED BY public.groups.id;


--
-- TOC entry 198 (class 1259 OID 24593)
-- Name: tstudents_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.tstudents_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.tstudents_id_seq OWNER TO postgres;

--
-- TOC entry 2831 (class 0 OID 0)
-- Dependencies: 198
-- Name: tstudents_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.tstudents_id_seq OWNED BY public.students.id;


--
-- TOC entry 2691 (class 2604 OID 24582)
-- Name: groups id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.groups ALTER COLUMN id SET DEFAULT nextval('public.tgroups_id_seq'::regclass);


--
-- TOC entry 2692 (class 2604 OID 24598)
-- Name: students id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.students ALTER COLUMN id SET DEFAULT nextval('public.tstudents_id_seq'::regclass);


--
-- TOC entry 2822 (class 0 OID 24579)
-- Dependencies: 197
-- Data for Name: groups; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.groups (id, name) FROM stdin;
1	9ПО-41
2	9КС-41
\.


--
-- TOC entry 2824 (class 0 OID 24595)
-- Dependencies: 199
-- Data for Name: students; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.students (id, firstname, lastname, age, points, groupnum) FROM stdin;
1	Алексей	Заболотний	20	100	1
2	Махач	Абдулазизов	19	110	1
3	Алигаджи	Мусаев	17	90	1
4	Пётр	Иванов	18	105	2
\.


--
-- TOC entry 2832 (class 0 OID 0)
-- Dependencies: 196
-- Name: tgroups_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.tgroups_id_seq', 1, false);


--
-- TOC entry 2833 (class 0 OID 0)
-- Dependencies: 198
-- Name: tstudents_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.tstudents_id_seq', 1, false);


--
-- TOC entry 2694 (class 2606 OID 24607)
-- Name: groups tgroups_name_key; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.groups
    ADD CONSTRAINT tgroups_name_key UNIQUE (name);


--
-- TOC entry 2696 (class 2606 OID 24584)
-- Name: groups tgroups_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.groups
    ADD CONSTRAINT tgroups_pkey PRIMARY KEY (id);


--
-- TOC entry 2698 (class 2606 OID 24600)
-- Name: students tstudents_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.students
    ADD CONSTRAINT tstudents_pkey PRIMARY KEY (id);


--
-- TOC entry 2699 (class 2606 OID 24601)
-- Name: students tstudents_groupnum_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.students
    ADD CONSTRAINT tstudents_groupnum_fkey FOREIGN KEY (groupnum) REFERENCES public.groups(id);


-- Completed on 2021-03-03 02:56:29

--
-- PostgreSQL database dump complete
--

