import request from '@/utils/request'

// 查询内景图列表
export function listInteriorview(query) {
  return request({
    url: '/system/interiorview/list',
    method: 'get',
    params: query
  })
}

// 查询内景图详细
export function getInteriorview(id) {
  return request({
    url: '/system/interiorview/' + id,
    method: 'get'
  })
}

// 新增内景图
export function addInteriorview(data) {
  return request({
    url: '/system/interiorview',
    method: 'post',
    data: data
  })
}

// 修改内景图
export function updateInteriorview(data) {
  return request({
    url: '/system/interiorview',
    method: 'put',
    data: data
  })
}

// 删除内景图
export function delInteriorview(id) {
  return request({
    url: '/system/interiorview/' + id,
    method: 'delete'
  })
}

// 导出内景图
export function exportInteriorview(query) {
  return request({
    url: '/system/interiorview/export',
    method: 'get',
    params: query
  })
}