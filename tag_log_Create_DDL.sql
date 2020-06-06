-- Table: public.tag_log

-- DROP TABLE public.tag_log;

CREATE TABLE public.tag_log
(
    tag_log_id bigint NOT NULL,
    tag character varying(25) COLLATE pg_catalog."default",
    unit character varying(35) COLLATE pg_catalog."default",
    c_x character varying(30) COLLATE pg_catalog."default",
    c_y character varying(30) COLLATE pg_catalog."default",
    c_z character varying(30) COLLATE pg_catalog."default",
    tag_group character varying(35) COLLATE pg_catalog."default",
    zone character varying(35) COLLATE pg_catalog."default",
    tag_log_date character varying(30) COLLATE pg_catalog."default",
    tag_index character varying(25) COLLATE pg_catalog."default",
    date_track character varying COLLATE pg_catalog."default",
    track_datetime character varying COLLATE pg_catalog."default",
    track_date character varying COLLATE pg_catalog."default",
    track_time character varying COLLATE pg_catalog."default",
    status bigint,
    add_by character varying(15) COLLATE pg_catalog."default",
    mdf_by character varying(15) COLLATE pg_catalog."default",
    add_dt character varying COLLATE pg_catalog."default",
    mdf_dt character varying COLLATE pg_catalog."default"
)

TABLESPACE pg_default;

ALTER TABLE public.tag_log
    OWNER to postgres;