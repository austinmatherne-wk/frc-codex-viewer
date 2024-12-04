package com.frc.codex.database.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import com.frc.codex.model.RegistryCode;
import com.frc.codex.database.DatabaseManager;
import com.frc.codex.model.Company;
import com.frc.codex.model.Filing;
import com.frc.codex.model.FilingResultRequest;
import com.frc.codex.model.FilingStatus;
import com.frc.codex.model.NewFilingRequest;
import com.frc.codex.model.SearchFilingsRequest;
import com.frc.codex.model.companieshouse.CompaniesHouseArchive;

@Component
@Profile("test")
public class TestDatabaseManagerImpl implements DatabaseManager {
	public TestDatabaseManagerImpl() {}

	public void applyFilingResult(FilingResultRequest filingResultRequest) { }

	public boolean checkCompaniesLimit(int companiesLimit) {
		return false;
	}

	public boolean checkRegistryLimit(RegistryCode registryCode, int limit) {
		return false;
	}

	public boolean companiesHouseArchiveExists(String filename) {
		return false;
	}

	public boolean companyNumberExists(String companyNumber) {
		return false;
	}

	public String createCompaniesHouseArchive(CompaniesHouseArchive archive) {
		return null;
	}

	public UUID createFiling(NewFilingRequest newFilingRequest) {
		return null;
	}

	public boolean filingExists(String registryCode, String externalFilingId) {
		return false;
	}

	public Filing getFiling(UUID filingId) {
		return null;
	}

	public LocalDateTime getLatestFcaFilingDate(LocalDateTime defaultDate) {
		return null;
	}

	public Long getLatestStreamTimepoint(Long defaultTimepoint) {
		return defaultTimepoint;
	}

	public List<Filing> getFilingsByStatus(FilingStatus status) {
		return List.of();
	}

	public List<Filing> getFilingsByStatus(FilingStatus status, RegistryCode registryCode) {
		return List.of();
	}

	public long getRegistryCount(RegistryCode registryCode) {
		return 0;
	}

	public void resetFiling(UUID filingId) { }

	public List<Filing> searchFilings(SearchFilingsRequest searchFilingsRequest) {
		return List.of();
	}

	private Filing.Builder copyFiling(UUID filingId) {
		return Filing.builder();
	}

	private void updateFiling(Filing filing) {}

	public void updateFilingStatus(UUID filingId, String status) { }

	public Set<String> getCompaniesCompanyNumbers() {
		return Set.of();
	}

	public void createCompany(Company company) { }

	public void updateCompany(Company company) { }

	public List<Company> getIncompleteCompanies(int limit) {
		return List.of();
	}

	public boolean isHealthy() {
		return true;
	}
}
