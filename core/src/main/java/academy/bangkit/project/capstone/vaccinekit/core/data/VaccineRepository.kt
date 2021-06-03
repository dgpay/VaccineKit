package academy.bangkit.project.capstone.vaccinekit.core.data

import academy.bangkit.project.capstone.vaccinekit.core.data.source.remote.RemoteDataSource
import academy.bangkit.project.capstone.vaccinekit.core.domain.model.LoginUser
import academy.bangkit.project.capstone.vaccinekit.core.domain.model.NIKBarcode
import academy.bangkit.project.capstone.vaccinekit.core.domain.model.Vaccine
import academy.bangkit.project.capstone.vaccinekit.core.domain.model.Verification
import academy.bangkit.project.capstone.vaccinekit.core.domain.repository.IVaccineRepository
import academy.bangkit.project.capstone.vaccinekit.core.utils.DataMapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class VaccineRepository(private val remoteDataSource: RemoteDataSource) : IVaccineRepository {
    override fun loginUser(nik: String, pass: String): Flow<LoginUser> {
        return remoteDataSource.loginUser(nik, pass).map {
            DataMapper.mapLoginUser(it)
        }
    }

    override fun getVaccineData(nik: String): Flow<Vaccine> {
        return remoteDataSource.getVaccineData(nik).map {
            DataMapper.mapResponseToDomain(it)
        }
    }

    override fun getDataByBarcode(barcode: String): Flow<Vaccine> {
        return remoteDataSource.getDataByBarcode(barcode).map {
            DataMapper.mapResponseToDomain(it)
        }
    }

    override fun getVerification(nik: String): Flow<Verification> {
        return remoteDataSource.getVerifNik(nik).map {
            DataMapper.mapVerifResponseToDomain(it)
        }
    }

    override fun getNIKBarcode(nik: String, photos: String): Flow<NIKBarcode> {
        return remoteDataSource.getVerifNIKBarcode(nik, photos).map {
            DataMapper.mapNIKBarcode(it)
        }
    }

    override fun addVaccineData(
        nik: String,
        name: String,
        address: String,
        photos: String,
        ttl: String,
        firstVaccineData: String,
        secondVaccineDate: String,
        vaccineStatus: String
    ) = remoteDataSource.postVaccineData(
        nik,
        name,
        address,
        photos,
        ttl,
        firstVaccineData,
        secondVaccineDate,
        vaccineStatus
    )


}