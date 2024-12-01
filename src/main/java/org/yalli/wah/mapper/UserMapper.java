package org.yalli.wah.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;
import org.yalli.wah.dao.entity.UserEntity;
import org.yalli.wah.model.dto.MemberDto;
import org.yalli.wah.model.dto.MemberInfoDto;
import org.yalli.wah.model.dto.MemberUpdateDto;
import org.yalli.wah.model.dto.RegisterDto;

@Mapper
public abstract class UserMapper {
    public static final UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    @Mapping(target = "socialMediaAccounts", source = "socialMediaLinks")
    @Mapping(target = "accessToken", ignore = true)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    public abstract UserEntity mapRegisterDtoToUser(RegisterDto registerDto, @MappingTarget UserEntity userEntity);


    @Mapping(source = "profilePictureUrl", target = "profilePicture")
    @Mapping(source = "socialMediaAccounts", target = "socialMediaLinks")
    public abstract MemberDto mapUserEntityToMemberDto(UserEntity userEntity);


    //    @Mapping(target = "id", ignore = true)
//    @Mapping(target = "updatedAt", ignore = true)
    public abstract MemberInfoDto mapUserEntityToMemberInfoDto(UserEntity userEntity);


    public abstract UserEntity updateMember(@MappingTarget UserEntity userEntity, MemberUpdateDto memberInfoDto);
}
