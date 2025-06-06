package com.vendorloginservice.mapper;

import com.vendorloginservice.domain.VendorAddressDTO;
import com.vendorloginservice.domain.VendorDetailsDTO;
import com.vendorloginservice.entity.VendorAddress;
import com.vendorloginservice.entity.VendorDetails;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-06-06T14:33:31+0530",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.41.0.v20250213-1140, environment: Java 21.0.6 (Eclipse Adoptium)"
)
@Component
public class VendorMapperImpl implements VendorMapper {

    @Override
    public VendorDetailsDTO toDto(VendorDetails entity) {
        if ( entity == null ) {
            return null;
        }

        VendorDetailsDTO vendorDetailsDTO = new VendorDetailsDTO();

        vendorDetailsDTO.setVendor_id( String.valueOf( entity.getVendor_id() ) );
        vendorDetailsDTO.setV_firstName( entity.getV_firstName() );
        vendorDetailsDTO.setV_lastName( entity.getV_lastName() );
        vendorDetailsDTO.setV_mobile( entity.getV_mobile() );
        vendorDetailsDTO.setV_email( entity.getV_email() );
        vendorDetailsDTO.setVendorAddress( toDto( entity.getVendorAddress() ) );

        return vendorDetailsDTO;
    }

    @Override
    public VendorAddressDTO toDto(VendorAddress entity) {
        if ( entity == null ) {
            return null;
        }

        VendorAddressDTO vendorAddressDTO = new VendorAddressDTO();

        vendorAddressDTO.setV_address_Id( String.valueOf( entity.getV_address_id() ) );
        vendorAddressDTO.setV_address1( entity.getV_address1() );
        vendorAddressDTO.setV_city( entity.getV_city() );
        vendorAddressDTO.setV_state( entity.getV_state() );
        vendorAddressDTO.setV_zipcode( entity.getV_zipcode() );

        return vendorAddressDTO;
    }

    @Override
    public VendorDetails toEntity(VendorDetailsDTO dto) {
        if ( dto == null ) {
            return null;
        }

        VendorDetails vendorDetails = new VendorDetails();

        if ( dto.getVendor_id() != null ) {
            vendorDetails.setVendor_id( Long.parseLong( dto.getVendor_id() ) );
        }
        vendorDetails.setV_firstName( dto.getV_firstName() );
        vendorDetails.setV_lastName( dto.getV_lastName() );
        vendorDetails.setV_mobile( dto.getV_mobile() );
        vendorDetails.setV_email( dto.getV_email() );
        vendorDetails.setVendorAddress( toEntity( dto.getVendorAddress() ) );

        return vendorDetails;
    }

    @Override
    public VendorAddress toEntity(VendorAddressDTO dto) {
        if ( dto == null ) {
            return null;
        }

        VendorAddress vendorAddress = new VendorAddress();

        if ( dto.getV_address_Id() != null ) {
            vendorAddress.setV_address_id( Long.parseLong( dto.getV_address_Id() ) );
        }
        vendorAddress.setV_address1( dto.getV_address1() );
        vendorAddress.setV_city( dto.getV_city() );
        vendorAddress.setV_state( dto.getV_state() );
        vendorAddress.setV_zipcode( dto.getV_zipcode() );

        return vendorAddress;
    }

    @Override
    public List<VendorDetailsDTO> toDtoList(List<VendorDetails> entities) {
        if ( entities == null ) {
            return null;
        }

        List<VendorDetailsDTO> list = new ArrayList<VendorDetailsDTO>( entities.size() );
        for ( VendorDetails vendorDetails : entities ) {
            list.add( toDto( vendorDetails ) );
        }

        return list;
    }
}
