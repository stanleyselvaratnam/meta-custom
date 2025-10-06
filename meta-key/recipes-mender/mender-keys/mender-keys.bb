SUMMARY = "Install Mender artifact verification key"
LICENSE = "CLOSED"
SRC_URI = "file://public.key"

inherit allarch

S = "${WORKDIR}"

do_install() {
    install -d ${D}${sysconfdir}/mender
    install -m 0644 ${WORKDIR}/public.key ${D}${sysconfdir}/mender/artifact-verify-key.pem
}

FILES_${PN} += "${sysconfdir}/mender/artifact-verify-key.pem"
