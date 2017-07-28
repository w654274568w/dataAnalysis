package cn.dataAnalysis.api.dto.convert;

import cn.dataAnalysis.api.dto.DataCountByRegionDTO;
import cn.dataAnalysis.model.DataCountByRegion;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Sun
 * @version 1.0
 * @date 2016年6月6日 上午11:07:34
 */
public class DataCountByRegionConvert {

    /**
     * 将城市价格信息POJO实体转换为城市价格信表业务实体
     *
     * @param dataCountByRegion 城市表POJO实体
     * @return DataCountByRegionDTO 城市表业务实体
     */
    public static final DataCountByRegionDTO convertToDTO(DataCountByRegion dataCountByRegion) {
        if (null == dataCountByRegion) {
            return null;
        }
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd");
        DataCountByRegionDTO dataCountByRegionDTO = new DataCountByRegionDTO();
        dataCountByRegionDTO.setAttentionNumber(dataCountByRegion.getAttentionNumber());
        dataCountByRegionDTO.setAveragePerPrice(dataCountByRegion.getAveragePerPrice());
        dataCountByRegionDTO.setAverageTotalPrice(dataCountByRegion.getAverageTotalPrice());
        dataCountByRegionDTO.setCaptureTime(dateFormat.format(dataCountByRegion.getCaptureTime()));
        dataCountByRegionDTO.setId(dataCountByRegion.getId());
        dataCountByRegionDTO.setNumber(dataCountByRegion.getNumber());
        dataCountByRegionDTO.setRegionCode(dataCountByRegion.getRegionCode());
        dataCountByRegionDTO.setRegionName(dataCountByRegion.getRegionName());
        return dataCountByRegionDTO;
    }


    public static final List<DataCountByRegionDTO> convertToDTOs(List<DataCountByRegion> list) {
        if (0 == list.size()) {
            return new ArrayList<DataCountByRegionDTO>();
        }
        List<DataCountByRegionDTO> dataCountByRegionDTOS = new ArrayList<DataCountByRegionDTO>();
        for (DataCountByRegion dataCountByRegion : list) {
            dataCountByRegionDTOS.add(DataCountByRegionConvert.convertToDTO(dataCountByRegion));
        }
        return dataCountByRegionDTOS;
    }


    /**
     * 将城市表业务实体转换为城市表POJO实体
     *
     * @param CityDTO 城市表业务实体类
     * @return City 城市表POJO实体
     *//*
    public static final City convertToBean(CityDTO cityDTO) {
        if (null == cityDTO) {
            return null;
        }
        return city;
    }

    *//**
     * 将城市表业务实体对象集合转换为城市表持久化对象集合
     *
     * @param listCityDTO 城市表业务实体对象集合
     * @return List<City> 城市表持久化对象集合
     *//*
    public static final List<City> convertToBeans(List<CityDTO> cityDTOs) {
        if (CollectionUtil.isEmpty(cityDTOs)) {
            return new ArrayList<City>();
        }
        List<City> listCity = new ArrayList<City>();

        for (CityDTO cityDTO : cityDTOs) {
            listCity.add(DataCountByRegionConvert.convertToBean(cityDTO));
        }
        return listCity;
    }

    *//**
     * 将城市表持久化对象集合集合转换为城市表业务实体对象
     *
     * @param listCity 城市表持久化对象集合
     * @return PageBean<CityDTO> 城市表业务实体对象集合
     *//*
    public static final PageBean<CityDTO> convertPage(Page<City> CityPage) {
        PageBean<CityDTO> page = new PageBean<CityDTO>();
        if (CityPage.getTotalElements() == 0L) {
            return page;
        }
        List<City> list = CityPage.getContent();
        List<CityDTO> items = convertToDTOs(list);
        page.setPage(CityPage.getNumber() + 1);
        page.setTotal(CityPage.getTotalPages());
        page.setRecords(CityPage.getTotalElements());
        page.setRows(items);
        return page;
    }*/
}
