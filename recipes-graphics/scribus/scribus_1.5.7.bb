SUMMARY = "Scribus: Open source desktop publishing"
HOMEPAGE = "https://www.scribus.net/"
LICENSE = "GPL-2.0-or-later & LGPL-2.0-or-later & BSD-3-Clause & MIT"
LIC_FILES_CHKSUM = "file://COPYING;md5=46d73026c0f1b3a4016bc06a677411ab"

inherit cmake_qt5 cmake_extra_sanity pkgconfig python3native gtk-icon-cache mime mime-xdg

DEPENDS += " \
    qttools-native \
    boost \
    tiff \
    lcms \
    hunspell \
    poppler \
"

SRC_URI = " \
    ${SOURCEFORGE_MIRROR}/project/${BPN}/${BPN}-devel/${PV}/${BPN}-${PV}.tar.xz \
    file://0001-Use-new-hb-subset-api-with-harfbuzz-2.9.0-in-order-t.patch \
    file://0002-16635-Replace-hb_subset-removed-in-harfbuzz-3.0-by-h.patch \
"
SRC_URI[sha256sum] = "318316b2cfc7a76191d3e0d3f8c2265147daea0570162028e243c292d826f8ce"

# necessary since poppler 21.01.0
EXTRA_OECMAKE = "-DWANT_CPP17=ON"

FILES:${PN} += " \
    ${datadir}/icons \
    ${datadir}/mime \
    ${datadir}/metainfo \
"