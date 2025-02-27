project(mapshot_tool)

include_directories(
  ${OMIM_ROOT}/3party/glm
)

set(
  SRC
  mapshot.cpp
)

omim_add_executable(${PROJECT_NAME} ${SRC})
target_link_libraries(${PROJECT_NAME} gflags::gflags)

omim_link_libraries(
  ${PROJECT_NAME}
  map
  ge0
  software_renderer
  drape_frontend
  shaders
  routing
  search
  storage
  tracking
  traffic
  routing_common
  transit
  descriptions
  drape
  kml
  indexer
  platform
  mwm_diff
  bsdiff
  editor
  geometry
  coding
  base
  freetype
  expat
  icu
  agg
  jansson
  protobuf
  minizip
  succinct
  pugixml
  oauthcpp
  opening_hours
  stb_image
  sdf_image
  vulkan_wrapper
  ${LIBZ}
)

if (PLATFORM_LINUX)
  omim_link_libraries(
    ${PROJECT_NAME}
    dl
  )
endif()

link_opengl(${PROJECT_NAME})
link_qt5_core(${PROJECT_NAME})
