package academy.bangkit.project.capstone.vaccinekit.core.data

import academy.bangkit.project.capstone.vaccinekit.core.data.source.remote.RemoteDataSource
import academy.bangkit.project.capstone.vaccinekit.core.domain.model.Vaccine
import academy.bangkit.project.capstone.vaccinekit.core.domain.model.Verification
import academy.bangkit.project.capstone.vaccinekit.core.domain.repository.IVaccineRepository
import academy.bangkit.project.capstone.vaccinekit.core.utils.DataMapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class VaccineRepository(private val remoteDataSource: RemoteDataSource) : IVaccineRepository {

    override fun getVaccineData(nik: String): Flow<Vaccine> {
        return remoteDataSource.getVaccineData(nik).map {
            DataMapper.mapResponseToDomain(it)
        }
    }

    override fun getVerification(nik: String): Flow<Verification> {
        return remoteDataSource.getVerifNik(nik).map {
            DataMapper.mapVerifResponseToDomain(it)
        }
    }
}