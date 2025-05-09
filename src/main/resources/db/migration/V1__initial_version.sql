-- Reasoning behind how different date columns types are chosen:
-- https://stackoverflow.com/questions/6627289/what-is-the-most-recommended-way-to-store-time-in-postgresql-using-java

CREATE TABLE IF NOT EXISTS filings (
    -- Database-generated fields
    filing_id uuid NOT NULL DEFAULT gen_random_uuid(),
    discovered_date TIMESTAMPTZ NOT NULL DEFAULT CURRENT_TIMESTAMP,
    -- Required fields
    status VARCHAR(50) NOT NULL,
    registry_code VARCHAR(20) NOT NULL,
    download_url VARCHAR(500) NOT NULL,
    -- Fields that may or may not be known before processing
    company_name VARCHAR(100),
    company_number VARCHAR(20),
    external_filing_id VARCHAR(50),
    external_view_url VARCHAR(500),
    filename VARCHAR(255),
    filing_type VARCHAR(20),
    filing_date TIMESTAMP,
    document_date TIMESTAMP,
    stream_timepoint BIGINT,
    -- Result assets
    error TEXT,
    logs TEXT,
    stub_viewer_url VARCHAR(500),
    oim_csv_url VARCHAR(500),
    oim_json_url VARCHAR(500),

    PRIMARY KEY (filing_id)
);
CREATE INDEX company_name_idx ON filings (company_name);
CREATE INDEX company_name_tsv_idx ON filings USING GIN (to_tsvector('english', company_name));
CREATE INDEX company_number_idx ON filings (company_number);

CREATE TABLE IF NOT EXISTS ch_archives (
    filename varchar(500) NOT NULL,
    uri varchar(500) NOT NULL,
    archive_type varchar(10),
    completed_date TIMESTAMPTZ NOT NULL DEFAULT CURRENT_TIMESTAMP,

    PRIMARY KEY (filename)
);
CREATE INDEX ch_archives_idx ON ch_archives (filename);
