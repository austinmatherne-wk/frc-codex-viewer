package com.frc.codex;

import com.zaxxer.hikari.HikariConfig;

public interface FilingIndexProperties {
	String awsAccessKeyId();
	String awsHost();
	String awsRegion();
	String awsSecretAccessKey();
	String companiesHouseDocumentApiBaseUrl();
	String companiesHouseInformationApiBaseUrl();
	String companiesHouseRestApiKey();
	String companiesHouseStreamApiBaseUrl();
	String companiesHouseStreamApiKey();
	String fcaDataApiBaseUrl();
	String fcaSearchApiUrl();
	HikariConfig getDatabaseConfig(String poolName);
	boolean isDbMigrateAsync();
	long maximumSearchResults();
	long searchPageSize();
}
